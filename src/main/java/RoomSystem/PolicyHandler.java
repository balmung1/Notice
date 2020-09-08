package RoomSystem;

import RoomSystem.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRoomRegistered_Notice(@Payload RoomRegistered roomRegistered){

        if(roomRegistered.isMe()){
            System.out.println("##### RoomRegistered Notice : " + roomRegistered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRoomDelete_Notice(@Payload RoomDelete roomDelete){

        if(roomDelete.isMe()){
            System.out.println("##### RoomDelete Notice : " + roomDelete.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_Notice(@Payload Reserved reserved){

        if(reserved.isMe()){
            System.out.println("##### Reserved Notice : " + reserved.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_Notice(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### ReservationCanceled Notice : " + reservationCanceled.toJson());
        }
    }

}
