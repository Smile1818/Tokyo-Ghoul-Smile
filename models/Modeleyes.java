
public static class Modeleyes extends ModelBase {
	private final ModelRenderer bb_main;

	public Modeleyes() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 12, 2.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 12, 0, -5.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -7.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 6, 2.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}