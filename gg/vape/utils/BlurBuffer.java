package gg.vape.utils;


import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.wrapper.impl.Framebuffer;
import gg.vape.wrapper.impl.ScaledResolution;
import org.lwjgl.opengl.Display;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lwjgl.BufferUtils.createFloatBuffer;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.glBlendFuncSeparate;
import static org.lwjgl.opengl.GL20.*;

public final class BlurBuffer {


    public static final String VERTEX_SHADER =
            "#version 120 \n" +
                    "\n" +
                    "void main() {\n" +
                    "    gl_TexCoord[0] = gl_MultiTexCoord0;\n" +
                    "    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n" +
                    "}";

    private static final String BLUR_FRAG_SHADER =
            "#version 120\n" +
                    "\n" +
                    "uniform sampler2D texture;\n" +
                    "uniform sampler2D texture2;\n" +
                    "uniform vec2 texelSize;\n" +
                    "uniform vec2 direction;\n" +
                    "uniform float radius;\n" +
                    "uniform float weights[256];\n" +
                    "\n" +
                    "void main() {\n" +
                    "    vec4 color = vec4(0.0);\n" +
                    "    vec2 texCoord = gl_TexCoord[0].st;\n" +
                    "    if (direction.y == 0)\n" +
                    "        if (texture2D(texture2, texCoord).a == 0.0) return;\n" +
                    "    for (float f = -radius; f <= radius; f++) {\n" +
                    "        color += texture2D(texture, texCoord + f * texelSize * direction) * (weights[int(abs(f))]);\n" +
                    "    }\n" +
                    "    gl_FragColor = vec4(color.rgb, 1.0);\n" +
                    "}";

    private static final GLShader blurShader = new GLShader(VERTEX_SHADER, BLUR_FRAG_SHADER) {
        @Override
        public void setupUniforms() {
            this.setupUniform("texture");
            this.setupUniform("texture2");
            this.setupUniform("texelSize");
            this.setupUniform("radius");
            this.setupUniform("direction");
            this.setupUniform("weights");
        }

        @Override
        public void updateUniforms() {
            ClickGui gui = (ClickGui) Vape.instance.getModManager().getMod(ClickGui.class);

            final float radius = gui.radius.getValue().floatValue();

            glUniform1i(this.getUniformLocation("texture"), 0);
            glUniform1i(this.getUniformLocation("texture2"), 20);
            glUniform1f(this.getUniformLocation("radius"), radius);
            glUniform1f(this.getUniformLocation("radius"), radius);

            final FloatBuffer buffer = createFloatBuffer(256);
            final float blurRadius = radius / 2f;
            for (int i = 0; i <= blurRadius; i++) {
                buffer.put(calculateGaussianOffset(i, radius / 4f));
            }
            buffer.rewind();

            glUniform1(this.getUniformLocation("weights"), buffer);

            glUniform2f(this.getUniformLocation("texelSize"),
                    1.0f / Display.getWidth(),
                    1.0f / Display.getHeight());
        }
    };

    public static boolean disableBlur;

    private static Framebuffer framebuffer, framebufferRender;

    private static List<double[]> blurAreas = new ArrayList<>();


    public static void blurArea(final double x, final double y, final double width, final double height) {
        if (disableBlur) return;
        blurAreas.add(new double[]{x, y, width, height});
    }


    public static void glDrawFilledQuad(final double x,
                                        final double y,
                                        final double width,
                                        final double height,
                                        final int startColour,
                                        final int endColour) {
        // Enable blending
        final boolean restore = glEnableBlend();
        // Disable texture drawing
        glDisable(GL_TEXTURE_2D);

        glShadeModel(GL_SMOOTH);

        // Begin rect
        glBegin(GL_QUADS);
        {
            glColour(startColour);
            glVertex2d(x, y);

            glColour(endColour);
            glVertex2d(x, y + height);
            glVertex2d(x + width, y + height);

            glColour(startColour);
            glVertex2d(x + width, y);
        }
        // Draw the rect
        glEnd();

        glShadeModel(GL_FLAT);

        // Disable blending
        glRestoreBlend(restore);
        // Re-enable texture drawing
        glEnable(GL_TEXTURE_2D);
    }


    public static void glColour(final int color) {
        glColor4ub((byte) (color >> 16 & 0xFF),
                (byte) (color >> 8 & 0xFF),
                (byte) (color & 0xFF),
                (byte) (color >> 24 & 0xFF));
    }


    public static void glDrawFilledQuad(final double x,
                                        final double y,
                                        final double width,
                                        final double height,
                                        final int colour) {
        // Enable blending
        final boolean restore = glEnableBlend();
        // Disable texture drawing
        glDisable(GL_TEXTURE_2D);
        // Set color
        glColour(colour);

        // Begin rect
        glBegin(GL_QUADS);
        {
            glVertex2d(x, y);
            glVertex2d(x, y + height);
            glVertex2d(x + width, y + height);
            glVertex2d(x + width, y);
        }
        // Draw the rect
        glEnd();

        // Disable blending
        glRestoreBlend(restore);
        // Re-enable texture drawing
        glEnable(GL_TEXTURE_2D);
    }


    public static void onRenderGameOverlay(final Framebuffer mcFramebuffer, final ScaledResolution sr) {
        if (framebuffer == null || framebufferRender == null || blurAreas.isEmpty()) return;
        framebufferRender.framebufferClear();
        // Draw into the blurFramebuffer
        framebufferRender.bindFramebuffer(false);
        // Draw the areas to be blurred
        for (final double[] area : blurAreas) {
            glDrawFilledQuad(area[0], area[1], area[2], area[3], 0xFF << 24);
        }

        blurAreas.clear();

        // Enable blending and using glBlendFuncSeparate
        final boolean restore = glEnableBlend();

        // Draw the first pass

        framebuffer.bindFramebuffer(false);
        blurShader.use(); // Use shader
        onPass(1); // Set direction
        // Draw the mcFramebuffer into the framebuffer
        glDrawFramebuffer(sr, mcFramebuffer);
        glUseProgram(0); // Stop using shader

        // Draw the second pass

        mcFramebuffer.bindFramebuffer(false);
        blurShader.use(); // Use shader
        onPass(0); // Update direction
        // Set texture 20 to the framebuffer drawn into by the event
        glActiveTexture(GL_TEXTURE20);
        glBindTexture(GL_TEXTURE_2D, framebufferRender.framebufferTexture());
        glActiveTexture(GL_TEXTURE0);
        // Draw the frame buffer onto screen
        glDrawFramebuffer(sr, framebuffer);
        glUseProgram(0); // Stop using shader

        // Restore the blend state
        glRestoreBlend(restore);
    }

    public static void glRestoreBlend(final boolean wasEnabled) {
        if (!wasEnabled) {
            glDisable(GL_BLEND);
        }
    }

    public static boolean glEnableBlend() {
        final boolean wasEnabled = glIsEnabled(GL_BLEND);

        if (!wasEnabled) {
            glEnable(GL_BLEND);
            glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        }

        return wasEnabled;
    }

    private static void onPass(final int pass) {
        glUniform2f(blurShader.getUniformLocation("direction"), 1 - pass, pass);
    }

    public static void glDrawFramebuffer(final ScaledResolution scaledResolution, final Framebuffer framebuffer) {
        // Bind framebuffer texture
        glBindTexture(GL_TEXTURE_2D, framebuffer.framebufferTexture());
        // Draw the frame buffer texture upside-down
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 1);
            glVertex2i(0, 0);

            glTexCoord2f(0, 0);
            glVertex2i(0, scaledResolution.getScaledHeight());

            glTexCoord2f(1, 0);
            glVertex2i(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());

            glTexCoord2f(1, 1);
            glVertex2i(scaledResolution.getScaledWidth(), 0);
        }
        glEnd();
    }

    public static void glDrawFramebuffer(final int framebufferTexture, final int width, final int height) {
        // Bind the texture of our framebuffer
        glBindTexture(GL_TEXTURE_2D, framebufferTexture);
        // Disable alpha testing so fading out outline works
        glDisable(GL_ALPHA_TEST);
        // Make sure blend is enabled
        final boolean restore = glEnableBlend();
        // Draw the frame buffer texture upside-down
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 1);
            glVertex2f(0, 0);

            glTexCoord2f(0, 0);
            glVertex2f(0, height);

            glTexCoord2f(1, 0);
            glVertex2f(width, height);

            glTexCoord2f(1, 1);
            glVertex2f(width, 0);
        }
        glEnd();
        // Restore blend
        glRestoreBlend(restore);
        // Restore alpha test
        glEnable(GL_ALPHA_TEST);
    }

    public static void onFrameBufferResize(final int width, final int height) {
        // Delete old buffers as to not cause a memory leak
        if (framebuffer != null)
            framebuffer.deleteFramebuffer();

        if (framebufferRender != null)
            framebufferRender.deleteFramebuffer();

        // Create new Framebuffers
        // False means it doesn't allocate a depth buffer which we don't need
        framebuffer = Framebuffer.c1231(width, height, false);
        framebufferRender = Framebuffer.c1231(width, height, false);
    }

    static float calculateGaussianOffset(float x, float sigma) {
        final float pow = x / sigma;
        return (float) (1.0 / (Math.abs(sigma) * 2.50662827463) * Math.exp(-0.5 * pow * pow));
    }

    public static class GLShader {

        private final Map<String, Integer> uniformLocationMap = new HashMap<>();
        private int program;

        public GLShader(final String vertexSource, final String fragSource) {
            this.program = glCreateProgram();

            // Attach vertex & fragment shader to the program
            glAttachShader(this.program, createShader(vertexSource, GL_VERTEX_SHADER));
            glAttachShader(this.program, createShader(fragSource, GL_FRAGMENT_SHADER));
            // Link the program
            glLinkProgram(this.program);
            // Check if linkage was a success
            final int status = glGetProgrami(this.program, GL_LINK_STATUS);
            // Check is status is a null ptr
            if (status == 0) {
                // Invalidate if error
                this.program = -1;
                return;
            }

            this.setupUniforms();
        }

        private static int createShader(final String source, final int type) {
            final int shader = glCreateShader(type); // Create new shader of passed type (vertex or fragment)
            glShaderSource(shader, source); // Specify the source (the code of the shader)
            glCompileShader(shader);               // Compile the code

            final int status = glGetShaderi(shader, GL_COMPILE_STATUS); // Check if the compilation succeeded

            if (status == 0) { // Equivalent to checking invalid ptr
                return -1;
            }

            return shader;
        }

        public void use() {
            // Use shader program
            glUseProgram(this.program);
            this.updateUniforms();
        }

        public int getProgram() {
            return program;
        }

        public void setupUniforms() {
        }

        public void updateUniforms() {
        }

        public void setupUniform(final String uniform) {
            this.uniformLocationMap.put(uniform, glGetUniformLocation(this.program, uniform));
        }

        public int getUniformLocation(final String uniform) {
            return this.uniformLocationMap.get(uniform);
        }
    }

}
