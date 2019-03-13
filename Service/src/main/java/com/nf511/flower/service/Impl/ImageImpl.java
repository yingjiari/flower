package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.ImageDao;
import com.nf511.flower.entity.Image;
import com.nf511.flower.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    public List<Image> selectAllImage() {
        return imageDao.selectAllImage();
    }

    public List<Image> selectAllFlowerId(int flowerId) {
        return imageDao.selectAllFlowerId(flowerId);
    }


    public List<Image> selectAllImageByPage(int pagelimit, int size) {
        return imageDao.selectAllImageByPage(pagelimit, size);
    }

    public int insertImage(Image image) {
        return imageDao.insertImage(image);
    }

    public int updateImage(Image image) {
        return imageDao.updateImage(image);
    }

    public int deleteImage(int imageId) {
        return imageDao.deleteImage(imageId);
    }

    public int deleteAll(List<Integer> items) {
        return imageDao.deleteAll(items);
    }
}
