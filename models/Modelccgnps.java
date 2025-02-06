
public static class Modelccgnps extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer Right Arm;
	private final ModelRenderer Left Arm;
	private final ModelRenderer Right Leg;
	private final ModelRenderer Left Leg;

	public Modelccgnps() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

		Right Arm = new ModelRenderer(this);
		Right Arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(Right Arm, -0.1745F, 0.0F, 0.0F);
		Right Arm.cubeList.add(new ModelBox(Right Arm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		Left Arm = new ModelRenderer(this);
		Left Arm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(Left Arm, 0.2094F, 0.0F, 0.0F);
		Left Arm.cubeList.add(new ModelBox(Left Arm, 32, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		Right Leg = new ModelRenderer(this);
		Right Leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		setRotationAngle(Right Leg, 0.192F, 0.0F, 0.0349F);
		Right Leg.cubeList.add(new ModelBox(Right Leg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		Left Leg = new ModelRenderer(this);
		Left Leg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(Left Leg, -0.1745F, 0.0F, -0.0349F);
		Left Leg.cubeList.add(new ModelBox(Left Leg, 16, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		Right Arm.render(f5);
		Left Arm.render(f5);
		Right Leg.render(f5);
		Left Leg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}