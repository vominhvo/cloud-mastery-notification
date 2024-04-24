package info.cloudmastery.microservices.notification.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//@JsonView(Views.Public.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseData<T> implements Serializable {
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private T data;

  private String message;

  private String code;

  private ResponseStatus status;

  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private Date timestamp;

  public static <T> ResponseData<T> of(T data) {
    ResponseData<T> responseData = new ResponseData<>();
    responseData.status = ResponseStatus.SUCCESS;
    responseData.data = data;
    responseData.timestamp = new Date();
    return responseData;
  }

  public static <T> ResponseData<T> ofFailure(T data, final String message, final String code) {
    ResponseData<T> responseData = new ResponseData<>();
    responseData.status = ResponseStatus.FAILURE;
    responseData.data = data;
    responseData.timestamp = new Date();
    responseData.code = code;
    responseData.message = message;
    return responseData;
  }

  public ResponseData(T data) {
    this.status = ResponseStatus.SUCCESS;
    this.data = data;
    this.timestamp = new Date();
  }

  public void setSuccess(T data) {
    this.status = ResponseStatus.SUCCESS;
    this.data = data;
    this.timestamp = new Date();
  }
}
