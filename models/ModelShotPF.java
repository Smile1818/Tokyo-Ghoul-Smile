
public static class ModelShotPF extends ModelBase {
	private final ModelRenderer Shot;

	public ModelShotPF() {
		textureWidth = 64;
		textureHeight = 64;

		Shot = new ModelRenderer(this);
		Shot.setRotationPoint(0.0F, 24.0F, 0.0F);
		Shot.cubeList.add(new ModelBox(Shot, 0, 0, 0.0F, -34.0F, 0.0F, 1, 40, 1, 0.0F, false));
		Shot.cubeList.add(new ModelBox(Shot, 4, 0, -1.0F, -28.0F, -1.0F, 3, 25, 3, 0.0F, false));
		Shot.cubeList.add(new ModelBox(Shot, 16, 0, -2.0F, -21.0F, -2.0F, 5, 11, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Shot.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}