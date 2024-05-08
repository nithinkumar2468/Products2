package com.infinite.crm.Products2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*@Document(collection = "products2")
@Data
@AllArgsConstructor
@NoArgsConstructor*/
/*public record Products2(Long id,String pname,String rating,Long price,String brand) {

    *//*@Id
    private Long id;

    private String pname;

    private String rating;

    private Long price;

    private String brand;*//*


}*/
public record Products2(Long id, String pname, String rating, Long price, String brand) {}
