package utils.dot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
public class Dot {
    private double x;
    private double y;
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
