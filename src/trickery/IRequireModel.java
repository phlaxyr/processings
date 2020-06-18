package trickery;

public interface IRequireModel<M extends IObjectModel> {
	void initModel(M m);
	M getModel();
}
