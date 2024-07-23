package univaq.disim.sose.vehiculeservice.web.grpc;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import univaq.disim.sose.vehiculeservice.entites.Owner;
import univaq.disim.sose.vehiculeservice.repositories.OwnerRepository;
import univaq.disim.sose.vehiculeservice.web.grpc.stub.*;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

/**
 * gRPC service implementation for handling owner-related requests.
 */
@GrpcService
@AllArgsConstructor
public class OwnerGrpcService extends OwnerGrpcServiceGrpc.OwnerGrpcServiceImplBase {
    
    // Repository for accessing owner data
    private OwnerRepository ownerRepository;

    /**
     * Handles the gRPC request to get an owner by ID.
     * 
     * @param request The gRPC request containing the owner ID.
     * @param responseObserver The gRPC response observer to send the response.
     */
    @Override
    public void getOwner(OwnerService.GetOwnerRequest request, StreamObserver<OwnerService.GetOwnerResponse> responseObserver) {
        // Retrieve the owner ID from the request
        Long ownerId = request.getId();
        // Find the owner in the repository
        Owner owner = ownerRepository.findById(ownerId).orElse(null);

        OwnerService.GetOwnerResponse response;
        if (owner != null) {
            // Convert the owner's birth date to a gRPC Timestamp
            Timestamp birthDateTimestamp = Timestamp.newBuilder()
                    .setSeconds(owner.getBirthDate().getTime() / 1000)  // Convert milliseconds to seconds
                    .setNanos((int) ((owner.getBirthDate().getTime() % 1000) * 1000000))  // Convert remainder milliseconds to nanoseconds
                    .build();
            // Build the gRPC owner object
            OwnerService.Owner grpcOwner = OwnerService.Owner.newBuilder()
                    .setId(owner.getId())
                    .setName(owner.getName())
                    .setBirthDate(birthDateTimestamp)
                    .setEmail(owner.getEmail())
                    .build();

            // Create the response with the found owner
            response = OwnerService.GetOwnerResponse.newBuilder()
                    .setOwner(grpcOwner)
                    .build();
        } else {
            // Return an empty response if the owner is not found
            response = OwnerService.GetOwnerResponse.newBuilder().build();
        }

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * Handles the gRPC request to list all owners.
     * 
     * @param request The gRPC request.
     * @param responseObserver The gRPC response observer to send the response.
     */
    @Override
    public void listOwners(OwnerService.GetAllOwnersRequest request, StreamObserver<OwnerService.GetAllOwnersResponse> responseObserver) {
        // Retrieve all owners from the repository
        List<Owner> owners = ownerRepository.findAll();

        // Build the response with the list of owners
        OwnerService.GetAllOwnersResponse.Builder responseBuilder = OwnerService.GetAllOwnersResponse.newBuilder();
        for (Owner owner : owners) {
            // Convert the owner's birth date to a gRPC Timestamp
            Timestamp birthDateTimestamp = Timestamp.newBuilder()
                    .setSeconds(owner.getBirthDate().getTime() / 1000)  // Convert milliseconds to seconds
                    .setNanos((int) ((owner.getBirthDate().getTime() % 1000) * 1000000))  // Convert remainder milliseconds to nanoseconds
                    .build();
            // Build the gRPC owner object
            OwnerService.Owner grpcOwner = OwnerService.Owner.newBuilder()
                    .setId(owner.getId())
                    .setName(owner.getName())
                    .setBirthDate(birthDateTimestamp)
                    .setEmail(owner.getEmail())
                    .build();

            // Add the owner to the response
            responseBuilder.addOwners(grpcOwner);
        }

        // Build and send the response
        OwnerService.GetAllOwnersResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
