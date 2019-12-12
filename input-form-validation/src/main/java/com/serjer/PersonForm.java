package com.serjer;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PersonForm {

  @NotNull
  @Size(min=2, max=30)
  private String name;

  @NotNull
  @Min(18)
  private Integer age;

 
}