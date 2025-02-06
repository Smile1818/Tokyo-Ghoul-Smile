
public static class Modelshotpz extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone_r1;

	public ShotPF2() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone_r1 = new ModelRenderer(this);
		bone_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone_r1);
		setRotationAngle(bone_r1, 0.3927F, 0.0F, 0.0F);
		bone_r1.cubeList.add(new ModelBox(bone_r1, 0, 0, 0.0F, -4.0F, -1.0F, 0, 8, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}