package com.chengkx.mapper;

import com.chengkx.entity.Pet;

import java.util.List;

public interface PetMapper {

    public List<Pet> getPetsByUserId(Integer userId);

    public Pet getPetById(Integer id);

}
