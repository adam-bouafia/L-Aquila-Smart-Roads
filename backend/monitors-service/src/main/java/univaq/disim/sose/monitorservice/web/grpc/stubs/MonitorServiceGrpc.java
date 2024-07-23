package univaq.disim.sose.monitorservice.web.grpc.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: monitor-service.proto")
public final class MonitorServiceGrpc {

  private MonitorServiceGrpc() {}

  public static final String SERVICE_NAME = "MonitorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest,
      univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> getGenerateSpeedViolationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateSpeedViolations",
      requestType = univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest.class,
      responseType = univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest,
      univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> getGenerateSpeedViolationsMethod() {
    io.grpc.MethodDescriptor<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest, univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> getGenerateSpeedViolationsMethod;
    if ((getGenerateSpeedViolationsMethod = MonitorServiceGrpc.getGenerateSpeedViolationsMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getGenerateSpeedViolationsMethod = MonitorServiceGrpc.getGenerateSpeedViolationsMethod) == null) {
          MonitorServiceGrpc.getGenerateSpeedViolationsMethod = getGenerateSpeedViolationsMethod = 
              io.grpc.MethodDescriptor.<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest, univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "MonitorService", "GenerateSpeedViolations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation.getDefaultInstance()))
                  .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("GenerateSpeedViolations"))
                  .build();
          }
        }
     }
     return getGenerateSpeedViolationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitorServiceStub newStub(io.grpc.Channel channel) {
    return new MonitorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MonitorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MonitorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MonitorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateSpeedViolations(univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest request,
        io.grpc.stub.StreamObserver<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateSpeedViolationsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateSpeedViolationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest,
                univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation>(
                  this, METHODID_GENERATE_SPEED_VIOLATIONS)))
          .build();
    }
  }

  /**
   */
  public static final class MonitorServiceStub extends io.grpc.stub.AbstractStub<MonitorServiceStub> {
    private MonitorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateSpeedViolations(univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest request,
        io.grpc.stub.StreamObserver<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGenerateSpeedViolationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MonitorServiceBlockingStub extends io.grpc.stub.AbstractStub<MonitorServiceBlockingStub> {
    private MonitorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation> generateSpeedViolations(
        univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGenerateSpeedViolationsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MonitorServiceFutureStub extends io.grpc.stub.AbstractStub<MonitorServiceFutureStub> {
    private MonitorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GENERATE_SPEED_VIOLATIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MonitorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MonitorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_SPEED_VIOLATIONS:
          serviceImpl.generateSpeedViolations((univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.GenerateSpeedViolationRequest) request,
              (io.grpc.stub.StreamObserver<univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.SpeedViolation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return univaq.disim.sose.monitorservice.web.grpc.stubs.MonitorServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MonitorService");
    }
  }

  private static final class MonitorServiceFileDescriptorSupplier
      extends MonitorServiceBaseDescriptorSupplier {
    MonitorServiceFileDescriptorSupplier() {}
  }

  private static final class MonitorServiceMethodDescriptorSupplier
      extends MonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MonitorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MonitorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitorServiceFileDescriptorSupplier())
              .addMethod(getGenerateSpeedViolationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
