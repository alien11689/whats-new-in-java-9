module dpr.impl {
	requires dpr.api;
	provides com.dpr.api.IHello with com.dpr.impl.Hello;
}
