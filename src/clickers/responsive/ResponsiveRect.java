package clickers.responsive;

import rect.builder.FancyRect;

public class ResponsiveRect/*<R extends ISelectableModel>*/ extends FancyRect implements IRequireSelectionable{ //implements IRequireModel<R>{
//	R r;
	public ResponsiveRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}

	
	
	public ISelectionable info;
	@Override
	public void linkSelectionable(ISelectionable r) { 
		this.info = r;
	}
	
	@Override
	public void defaultCustomizations() {
		
		super.defaultCustomizations();
//		if(getModel().isSelected() && f2flag) {
		if(info.isSelected() && f2flag) {
			main.fill(select_fill);
		}
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
