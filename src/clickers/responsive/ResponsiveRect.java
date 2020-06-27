package clickers.responsive;

public class ResponsiveRect/* <R extends ISelectableModel> */ extends AbstractResponsiveRect implements IRequireSelectionable { // implements
																													// IRequireModel<R>{
//	R r;
	public ResponsiveRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public ResponsiveRect(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}





	public ISelectionable info;

	@Override
	public void linkSelectionable(ISelectionable r) {
		this.info = r;
	}

	@Override
	public ISelectionable getSelectable() {
		return info;
	}



//	@Override
//	public void initModel(R r) {
//		this.r = r;
//	}
//	@Override
//	public R getModel() {
//		return r;
//	}

}
