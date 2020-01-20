package learning.activemq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -6673794306122431778L;
    private String name;
    private int age;
    private String message;
}
