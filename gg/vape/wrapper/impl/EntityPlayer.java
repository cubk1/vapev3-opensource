package gg.vape.wrapper.impl;

public class EntityPlayer extends EntityLivingBase {
   public EntityPlayer(Object var1) {
      super(var1);
   }

   public void c4088() {
      vape.getMappings().entityPlayer.c6265(this.obj);
   }

   public void setItemInUse(ItemStack var1, int var2) {
      vape.getMappings().entityPlayer.c7249(this.obj, var1.getObject(), var2);
   }

   public int getItemInUseMaxCount() {
      return vape.getMappings().entityPlayer.getItemInUseMaxCount(this.obj);
   }

   public InventoryPlayer c89() {
      return new InventoryPlayer(vape.getMappings().entityPlayer.c6780(this.obj));
   }

   public Container c7368() {
      return new Container(vape.getMappings().entityPlayer.c5143(this.obj));
   }

   public void c5331(Entity var1) {
      vape.getMappings().entityPlayer.c6771(this.obj, var1.getObject());
   }

   public EntityFishHook c1194() {
      return new EntityFishHook(vape.getMappings().entityPlayer.c5156(this.obj));
   }

   public FoodStats c7791() {
      return new FoodStats(vape.getMappings().entityPlayer.c6946(this.obj));
   }

   public ItemStack getHeldItemHand() {
      return new ItemStack(vape.getMappings().entityPlayer.getHeldItemMainhand(this.obj));
   }

   public GameProfile c5323() {
      return new GameProfile(vape.getMappings().entityPlayer.c593(this.obj));
   }

   public Team c3258() {
      return new Team(vape.getMappings().entityPlayer.c2141(this.obj));
   }

   public PlayerCapabilities capabilities() {
      return new PlayerCapabilities(vape.getMappings().entityPlayer.c2100(this.obj));
   }

   public Container c5465() {
      return new Container(vape.getMappings().entityPlayer.c648(this.obj));
   }

   public float getCooledAttackStrength(float var1) {
      return vape.getMappings().entityPlayer.c2842(this.obj, var1);
   }

   public void resetCooldown() {
      vape.getMappings().entityPlayer.c5770(this.obj);
   }
   public void jump() {
      vape.getMappings().entityPlayer.jump(this.obj);
   }

   public boolean isBlocking() {
      return vape.getMappings().entityPlayer.isBlocking(this.obj);
   }

   public boolean isUsingItem() {
      return vape.getMappings().entityPlayer.isUsingItem(this.obj);
   }

   public void c3727() {
      vape.getMappings().entityPlayer.c2694(this.getObject());
   }

   public int c3213() {
      return vape.getMappings().entityPlayer.c3820(this.obj);
   }

   public double c6049() {
      return vape.getMappings().entityPlayer.c8309(this.obj);
   }

   public double c2369() {
      return vape.getMappings().entityPlayer.c7647(this.obj);
   }

   public double c6015() {
      return vape.getMappings().entityPlayer.c2113(this.obj);
   }

   public double c3475() {
      return vape.getMappings().entityPlayer.c6624(this.obj);
   }

   public double c5346() {
      return vape.getMappings().entityPlayer.c973(this.obj);
   }

   public double c3205() {
      return vape.getMappings().entityPlayer.c8365(this.obj);
   }

   public void c8320(double var1) {
      vape.getMappings().entityPlayer.c2636(this.obj, var1);
   }

   public void c6196(double var1) {
      vape.getMappings().entityPlayer.c1122(this.obj, var1);
   }

   public void c3078(double var1) {
      vape.getMappings().entityPlayer.c4458(this.obj, var1);
   }

   public void c2298(double var1) {
      vape.getMappings().entityPlayer.c7773(this.obj, var1);
   }

   public void c7558(double var1) {
      vape.getMappings().entityPlayer.c765(this.obj, var1);
   }

   public void c6526(double var1) {
       vape.getMappings().entityPlayer.c5802(this.obj, var1);
   }
}
