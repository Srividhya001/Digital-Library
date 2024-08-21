package com.example.DigitalLibrary.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor

@Builder
public class SearchBookRequest {

   /* {
        "searchKey":"name",
        "searchValue":"GoodBook",
        "operator":"like"
        }*/
    //or
  /* {
       "searchKey":"genre",
       "searchValue":"Thriler",
       "operator":"="
   }
  */
   @NotBlank
    private String searchKey;
    @NotBlank
    private String searchValue;
    @NotBlank
    private String operator;


   private static Set<String> allowedKeys=new HashSet<>();
   @Getter
   private static HashMap<String, List<String>> allowedKeyOperatorMap=new HashMap<>();

   SearchBookRequest(){
     allowedKeys.addAll(Arrays.asList("name","author_name","genre","pages","id"));
    allowedKeyOperatorMap.put("name",Arrays.asList("=","like"));
    allowedKeyOperatorMap.put("author_name",Arrays.asList("=","like"));
    allowedKeyOperatorMap.put("genre",Arrays.asList("=","like"));
    allowedKeyOperatorMap.put("pages",Arrays.asList("=",">","<","<=",">="));
    allowedKeyOperatorMap.put("id",Arrays.asList("=",">","<","<=",">="));

   }






}
