package info.cloudmastery.microservices.notification.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EmailResponse implements Serializable {
  private long id;
  private String title;
}
