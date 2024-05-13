package eu.york.york2024mc.app;

public interface OnResponse<T extends Object> {

    public void onSuccess(T data);

    public void onError(String error);
}
