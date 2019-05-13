
public aspect TraceAspect_Liu {
	pointcut classToTrace(): within(ComponentApp) || within(DataApp) || within(ServiceApp);
	
	pointcut constructorToTrace(): classToTrace() && execution(new(..));

	pointcut methodToTrace(): classToTrace() &&  execution(* *(..));

	before(): methodToTrace() {
		System.out.println("[BGN] " + thisJoinPointStaticPart.getSignature() + //
	    ", " + thisJoinPointStaticPart.getSourceLocation().getLine());
	}
	
	after(): methodToTrace() {
		System.out.println("[END] " + thisJoinPointStaticPart.getSourceLocation().getFileName());
	}
}
