package in.kuros.blog.grpc.server;

import in.kuros.blog.grpc.AddResponse;
import in.kuros.blog.grpc.CalculatorGrpc.CalculatorImplBase;
import in.kuros.blog.grpc.OperandRequest;
import io.grpc.stub.StreamObserver;

public class CalculatorImpl extends CalculatorImplBase {

    @Override
    public void add(final OperandRequest request, final StreamObserver<AddResponse> responseObserver) {
        final long sum = request.getX() + request.getY();

        final AddResponse addResponse = AddResponse
                .newBuilder()
                .setResult(sum)
                .build();

        responseObserver.onNext(addResponse);
        responseObserver.onCompleted();
    }
}
