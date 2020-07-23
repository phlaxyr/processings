package clickers.responsive;

public class ResponsiveTextbox extends AbstractResponsiveTextbox implements IRequireSelectionable {

	public ResponsiveTextbox(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}

	ISelectionable clickInfo;

	@Override
	public void acknowledgeContainer(ISelectionable info) {
		this.clickInfo = info;
	}

	@Override
	public ISelectionable getSelectable() {
		return clickInfo;
	}


}
