module example.impl {
	requires example.api;
  provides com.example.api.IExample with com.example.impl.Example;
}
