package gg.vape.mapping;

import gg.vape.mapping.mappings.*;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
   public static List<Mapping> mappings = new ArrayList<>();
   public MForgeVersion forgeVersion;
   public MMinecraft minecraft;
   public MGuiScreen guiScreen;
   public MSession session;
   public MGameSettings gameSettings;
   public MKeyBinding keyBinding;
   public MEntity entity;
   public MEntityPlayer entityPlayer;
   public MEntityPlayerSP entityPlayerSP;
   public MEntityLivingBase entityLivingBase;
   public MWorld world;
   public MWorldClient worldClient;
   public MFontRenderer fontRenderer;
   public MEvent event;
   public MRenderGameOverlayEvent renderGameOverlayEvent;
   public MPlayerTickEvent playerTickEvent;
   public MMovementInput movementInput;
   public MPlayerControllerMP playerControllerMP;
   public MVec3d vec3d;
   public MVec3I vec3I;
   public MAxisAlignedBB axisAlignedBB;
   public MRayTraceResult rayTraceResult;
   public MEntityEvent entityEvent;
   public MEntityRenderer entityRenderer;
   public MScaledResolution scaledResolution;
   public MBlockPos blockPos;
   public MRayTraceResult_Type rayTraceResult_type;
   public MInventoryPlayer inventoryPlayer;
   public MItemStack itemStack;
   public MItemPotion itemPotion;
   public MGuiContainer guiContainer;
   public MContainer container;
   public MSlot slot;
   public MEntityViewRenderEvent entityViewRenderEvent;
   public MEntityViewRenderEvent_FogColors entityViewRenderEvent_fogColors;
   public MEntityViewRenderEvent_FogDensity entityViewRenderEvent_fogDensity;
   public MEntityViewRenderEvent_RenderFogEvent entityViewRenderEvent_renderFogEvent;
   public MRenderWorldLastEvent renderWorldLastEvent;
   public MRenderManager renderManager;
   public MRender render;
   public MEntityOtherPlayerMP entityOtherPlayerMP;
   public MRenderLivingEvent renderLivingEvent;
   public MMouse mouse;
   public MBlock block;
   public MIBlockState blockState;
   public MEventBus eventBus;
   public MMouseEvent mouseEvent;
   public MMinecraftForge minecraftForge;
   public MShaderGroup shaderGroup;
   public MGlStateManager glStateManager;
   public MBlocks blocks;
   public MMaterial material;
   public MEntityClientPlayerMP entityClientPlayerMP;
   public MNetHandlerPlayClient netHandlerPlayClient;
   public MCPacketEntityAction packetEntityAction;
   public MCPacketAnimation packetAnimation;
   public MCPacketChatMessage packetChatMessage;
   public MCPacketPlayer_PositionRotation mcPacketPlayerPositionRotation;
   public MCPacketPlayer_Position mcPacketPlayerPosition;
   public MCPacketPlayer_Rotation mcPacketPlayerRotation;
   public MCPacketPlayer packetPlayer;
   public MC0BPacketEntityAction_Action mc0BPacketEntityActionAction;
   public MCPacketHeldItemChange packetHeldItemChange;
   public MPotion potion;
   public MPotionEffect potionEffect;
   public MTickEvent_Phase mTickEventPhase;
   public MTickEvent tickEvent;
   public MNetworkManager networkManager;
   public MChannel channel;
   public MPacket packet;
   public MNetworkManager_InboundHandlerTuplePacketListener networkManager_inboundHandlerTuplePacketListener;
   public MRenderItem renderItem;
   public MGuiChest guiChest;
   public MIInventory inventory;
   public MTimer timer;
   public MCPacketUseEntityOne packetUseEntityOne;
   public MCPacketUseEntity packetUseEntity;
   public MFoodStats foodStats;
   public MIAttributeInstance attributeInstance;
   public MAttributeModifier attributeModifier;
   public MSharedMonsterAttributes sharedMonsterAttributes;
   public MItem item;
   public MRenderGlobal renderGlobal;
   public MFramebuffer framebuffer;
   public MTeam team;
   public MITextComponent textComponent;
   public MNetworkPlayerInfo networkPlayerInfo;
   public MGameProfile gameProfile;
   public MTileEntity tileEntity;
   public MTessellator tessellator;
   public MWorldRenderer worldRenderer;
   public MDefaultVertexFormats defaultVertexFormats;
   public MVertexFormat vertexFormat;
   public MTileEntityMobSpawner tileEntityMobSpawner;
   public MMobSpawnerBaseLogic mobSpawnerBaseLogic;
   public MIRenderHandler renderHandler;
   public MWorldProvider worldProvider;
   public MRenderBlockOverlayEvent renderBlockOverlayEvent;
   public MPlayerCapabilities playerCapabilities;
   public MItemArmor itemArmor;
   public MEnchantmentHelper enchantmentHelper;
   public MEnchantment enchantment;
   public MNBTTagList tagList;
   public MNBTTagCompound tagCompound;
   public MSPacketExplosion packetExplosion;
   public MSPacketEntityVelocity packetEntityVelocity;
   public MRenderHandEvent renderHandEvent;
   public MEnumCreatureAttribute enumCreatureAttribute;
   public MDamageSource damageSource;
   public MItems items;
   public MTickEvent_RenderTickEvent tickEvent_renderTickEvent;
   public MRenderHelper renderHelper;
   public MINetHandlerPlayClient netHandlerPlayClient1;
   public MMouseHelper mouseHelper;
   public MPlayerEvent_NameFormat mPlayerEventNameFormat;
   public MTextComponentString textComponentString;
   public MClientChatReceivedEvent clientChatReceivedEvent;
   public MChunk chunk;
   public MIChunkProvider chunkProvider;
   public MBlockLiquid blockLiquid;
   public MIWorldNameable worldNameable;
   public MModelBiped modelBiped;
   public MModelBase modelBase;
   public MModelRenderer modelRenderer;
   public MModelPlayer modelPlayer;
   public MRenderPlayer renderPlayer;
   public MRenderLivingBase renderLivingBase;
   public MRegistrySimple registrySimple;
   public MResourceLocation resourceLocation;
   public MPlaySoundAtEntityEvent playSoundAtEntityEvent;
   public MEntityPotion entityPotion;
   public MEntityFishHook entityFishHook;
   public MPlayerInteractEvent playerInteractEvent;
   public MRenderPlayerEvent renderPlayerEvent;
   public MRenderPlayerEvent_Specials_Pre renderPlayerEvent_specials_pre;
   public MRenderPlayerEvent_SetArmorModel renderPlayerEvent_setArmorModel;
   public MEnumHand enumHand;
   public MClickType clickType;
   public MEntityEquipmentSlot entityEquipmentSlot;
   public MLaunchClassLoader launchClassLoader;
   public MEffectRenderer effectRenderer;
   public MPlayerEvent playerEvent;
   public MTileEntityChest tileEntityChest;
   public MTileEntityEnderChest tileEntityEnderChest;
   public MEnumFacing enumFacing;
   public MSPacketPlayerPosLook packetPlayerPosLook;
   public MITextureObject textureObject;
   public MTextureManager textureManager;
   public MGuiScreenEvent guiScreenEvent;
   public MEnumActionResult enumActionResult;
   public MItemTool itemTool;
   public MItem_ToolMaterial item_toolMaterial;
   public MArmorMaterial itemArmor_armorMaterial;
   public MTextComponentTranslation textComponentTranslation;
   public MStyle style;

   public void loadMappings() {
      this.forgeVersion = new MForgeVersion();
      this.minecraft = new MMinecraft();
      this.guiScreen = new MGuiScreen();
      this.session = new MSession();
      this.gameSettings = new MGameSettings();
      this.keyBinding = new MKeyBinding();
      this.entity = new MEntity();
      this.entityPlayer = new MEntityPlayer();
      this.entityPlayerSP = new MEntityPlayerSP();
      this.entityLivingBase = new MEntityLivingBase();
      this.world = new MWorld();
      this.worldClient = new MWorldClient();
      this.fontRenderer = new MFontRenderer();
      this.event = new MEvent();
      this.renderGameOverlayEvent = new MRenderGameOverlayEvent();
      this.playerTickEvent = new MPlayerTickEvent();
      this.movementInput = new MMovementInput();
      this.playerControllerMP = new MPlayerControllerMP();
      this.vec3d = new MVec3d();
      this.axisAlignedBB = new MAxisAlignedBB();
      this.rayTraceResult = new MRayTraceResult();
      this.entityEvent = new MEntityEvent();
      this.entityRenderer = new MEntityRenderer();
      this.scaledResolution = new MScaledResolution();
      this.rayTraceResult_type = new MRayTraceResult_Type();
      this.inventoryPlayer = new MInventoryPlayer();
      this.itemStack = new MItemStack();
      this.itemPotion = new MItemPotion();
      this.guiContainer = new MGuiContainer();
      this.container = new MContainer();
      this.slot = new MSlot();
      this.entityViewRenderEvent_fogColors = new MEntityViewRenderEvent_FogColors();
      this.entityViewRenderEvent_fogDensity = new MEntityViewRenderEvent_FogDensity();
      this.entityViewRenderEvent_renderFogEvent = new MEntityViewRenderEvent_RenderFogEvent();
      this.renderWorldLastEvent = new MRenderWorldLastEvent();
      this.renderManager = new MRenderManager();
      this.render = new MRender();
      this.modelBase = new MModelBase();
      this.entityOtherPlayerMP = new MEntityOtherPlayerMP();
      this.renderLivingEvent = new MRenderLivingEvent();
      this.mouse = new MMouse();
      this.block = new MBlock();
      this.eventBus = new MEventBus();
      this.mouseEvent = new MMouseEvent();
      this.minecraftForge = new MMinecraftForge();
      this.shaderGroup = new MShaderGroup();
      this.blocks = new MBlocks();
      this.material = new MMaterial();
      this.netHandlerPlayClient = new MNetHandlerPlayClient();
      this.packetAnimation = new MCPacketAnimation();
      this.packetEntityAction = new MCPacketEntityAction();
      this.packetChatMessage = new MCPacketChatMessage();
      this.packetPlayer = new MCPacketPlayer();
      this.mcPacketPlayerRotation = new MCPacketPlayer_Rotation();
      this.mcPacketPlayerPosition = new MCPacketPlayer_Position();
      this.mcPacketPlayerPositionRotation = new MCPacketPlayer_PositionRotation();
      this.packetHeldItemChange = new MCPacketHeldItemChange();
      this.potion = new MPotion();
      this.potionEffect = new MPotionEffect();
      this.mTickEventPhase = new MTickEvent_Phase();
      this.tickEvent = new MTickEvent();
      this.networkManager = new MNetworkManager();
      this.channel = new MChannel();
      this.packet = new MPacket();
      this.networkManager_inboundHandlerTuplePacketListener = new MNetworkManager_InboundHandlerTuplePacketListener();
      this.renderItem = new MRenderItem();
      this.guiChest = new MGuiChest();
      this.inventory = new MIInventory();
      this.timer = new MTimer();
      this.packetUseEntityOne = new MCPacketUseEntityOne();
      this.packetUseEntity = new MCPacketUseEntity();
      this.foodStats = new MFoodStats();
      this.attributeInstance = new MIAttributeInstance();
      this.attributeModifier = new MAttributeModifier();
      this.sharedMonsterAttributes = new MSharedMonsterAttributes();
      this.item = new MItem();
      this.renderGlobal = new MRenderGlobal();
      this.framebuffer = new MFramebuffer();
      this.team = new MTeam();
      this.textComponent = new MITextComponent();
      this.gameProfile = new MGameProfile();
      this.tileEntity = new MTileEntity();
      this.tessellator = new MTessellator();
      this.tileEntityMobSpawner = new MTileEntityMobSpawner();
      this.mobSpawnerBaseLogic = new MMobSpawnerBaseLogic();
      this.renderHandler = new MIRenderHandler();
      this.worldProvider = new MWorldProvider();
      this.renderBlockOverlayEvent = new MRenderBlockOverlayEvent();
      this.guiScreenEvent = new MGuiScreenEvent();
      this.playerCapabilities = new MPlayerCapabilities();
      this.itemArmor = new MItemArmor();
      this.enchantmentHelper = new MEnchantmentHelper();
      this.enchantment = new MEnchantment();
      this.tagList = new MNBTTagList();
      this.tagCompound = new MNBTTagCompound();
      this.packetExplosion = new MSPacketExplosion();
      this.packetEntityVelocity = new MSPacketEntityVelocity();
      this.renderHandEvent = new MRenderHandEvent();
      this.enumCreatureAttribute = new MEnumCreatureAttribute();
      this.damageSource = new MDamageSource();
      this.items = new MItems();
      this.tickEvent_renderTickEvent = new MTickEvent_RenderTickEvent();
      this.renderHelper = new MRenderHelper();
      this.netHandlerPlayClient1 = new MINetHandlerPlayClient();
      this.mouseHelper = new MMouseHelper();
      this.mPlayerEventNameFormat = new MPlayerEvent_NameFormat();
      this.textComponentString = new MTextComponentString();
      this.textComponentTranslation = new MTextComponentTranslation();
      this.style = new MStyle();
      this.clientChatReceivedEvent = new MClientChatReceivedEvent();
      this.chunk = new MChunk();
      this.chunkProvider = new MIChunkProvider();
      this.blockLiquid = new MBlockLiquid();
      this.modelBiped = new MModelBiped();
      this.modelRenderer = new MModelRenderer();
      this.renderLivingBase = new MRenderLivingBase();
      this.renderPlayer = new MRenderPlayer();
      this.registrySimple = new MRegistrySimple();
      this.resourceLocation = new MResourceLocation();
      this.playSoundAtEntityEvent = new MPlaySoundAtEntityEvent();
      this.entityPotion = new MEntityPotion();
      this.entityFishHook = new MEntityFishHook();
      this.playerInteractEvent = new MPlayerInteractEvent();
      this.renderPlayerEvent_specials_pre = new MRenderPlayerEvent_Specials_Pre();
      this.renderPlayerEvent_setArmorModel = new MRenderPlayerEvent_SetArmorModel();
      this.renderPlayerEvent = new MRenderPlayerEvent();
      this.playerEvent = new MPlayerEvent();
      this.tileEntityChest = new MTileEntityChest();
      this.tileEntityEnderChest = new MTileEntityEnderChest();
      this.packetPlayerPosLook = new MSPacketPlayerPosLook();
      this.enumFacing = new MEnumFacing();
      this.textureObject = new MITextureObject();
      this.textureManager = new MTextureManager();
      this.launchClassLoader = new MLaunchClassLoader();
      this.itemTool = new MItemTool();
      this.item_toolMaterial = new MItem_ToolMaterial();
      this.itemArmor_armorMaterial = new MArmorMaterial();
      if (ForgeVersion.minorVersion() > 13) {
         this.vec3I = new MVec3I();
         this.blockPos = new MBlockPos();
         this.blockState = new MIBlockState();
         this.glStateManager = new MGlStateManager();
         this.mc0BPacketEntityActionAction = new MC0BPacketEntityAction_Action();
         this.networkPlayerInfo = new MNetworkPlayerInfo();
         this.worldRenderer = new MWorldRenderer();
         this.defaultVertexFormats = new MDefaultVertexFormats();
         this.vertexFormat = new MVertexFormat();
         this.worldNameable = new MIWorldNameable();
         this.modelPlayer = new MModelPlayer();
         this.entityViewRenderEvent = new MEntityViewRenderEvent();
      } else {
         this.entityClientPlayerMP = new MEntityClientPlayerMP();
      }

      if (ForgeVersion.minorVersion() >= 23) {
         this.enumHand = new MEnumHand();
         this.clickType = new MClickType();
         this.entityEquipmentSlot = new MEntityEquipmentSlot();
         this.enumActionResult = new MEnumActionResult();
      } else {
         this.effectRenderer = new MEffectRenderer();
      }

   }
}
