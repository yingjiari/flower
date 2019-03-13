package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.AdminDao;
import com.nf511.flower.entity.Admin;
import com.nf511.flower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin selectAdmin(String adminAccount) {
        return adminDao.selectAdmin(adminAccount);
    }





    public List<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    public Admin selectAllAdminId(int adminId) {
        return adminDao.selectAllAdminId(adminId);
    }

    public List<Admin> selectAllAdminByPage(int pagelimit, int size) {
        return adminDao.selectAllAdminByPage(pagelimit, size);
    }

    public int insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    public int deleteAdmin(int adminId) {
        return adminDao.deleteAdmin(adminId);
    }

    public int deleteAll(List<Integer> items) {
        return adminDao.deleteAll(items);
    }
}
