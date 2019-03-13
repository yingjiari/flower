package com.nf511.flower.service;


import com.nf511.flower.entity.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageService {
    List<Image> selectAllImage();
    List<Image>selectAllFlowerId(@Param("flowerId") int flowerId);
    List<Image>selectAllImageByPage(@Param("pagelimit") int pagelimit, @Param("size") int size);
    int insertImage(Image image);
    int updateImage(Image image);
    int deleteImage(@Param("imageId") int imageId);
    int deleteAll(@Param("imageIds") List<Integer> items);
}
