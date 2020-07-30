package Services.JFrameTrainings;

public interface Name {
    default String getName1(){
        return (getClass().getName());
    }
}
