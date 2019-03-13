package com.nf511.flower.dao;

import com.nf511.flower.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    List<Address> selectAllAddress(int userId);
    int insertAddress(Address address);
    int getAddressCount(int userId);
    int updateAddressStateId(@Param("addressId") long addressId,@Param("stateId") long stateId);
    Address getAddressByMaxAddressId(int userId);





    Address selectAddressId(@Param("addressId") int addressId);
    List<Address>selectAllAddressByPage(@Param("pagelimit") int pagelimit, @Param("size") int size);
    int updateAddress(Address address);
    int deleteAddress(@Param("addressId") int addressId);
    int deleteAll(@Param("addressIds") List<Integer> items);

}
