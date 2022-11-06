package tn.gestionstock.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.gestionstock.Dto.CategoryDto;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

	
	/*
	 * @BeforeEach void setUp() throws Exception { }
	 * 
	 * @Test void test() { fail("Not yet implemented"); }
	 */
	 
	@Autowired
	private CategoryService catSer;
	@Test
	public void shouldSaveCategoryWithSuccess(){
	CategoryDto expectedCat=CategoryDto.builder().code("cat test").
			designation("designation test").idEntreprise(1).build();
	
	CategoryDto savedCategory=catSer.save(expectedCat);
	assertNotNull(savedCategory);
	Assertions.assertEquals(expectedCat.getCode(), savedCategory.getCode());
	Assertions.assertEquals(expectedCat.getDesignation(), savedCategory.getDesignation());
	Assertions.assertEquals(expectedCat.getIdEntreprise(), savedCategory.getIdEntreprise());
	//assertNotNull(savedCategory.getId());
	}
	@Test
	public void shouldUpdateCategoryWithSuccess(){
	CategoryDto expectedCat=CategoryDto.builder().code("cat testu").
			designation("designation testu").idEntreprise(1).build();
	
	CategoryDto savedCategory=catSer.save(expectedCat);
	CategoryDto categoryToUpdate=savedCategory;
	categoryToUpdate.setCode("cat update");
	catSer.save(categoryToUpdate);
	assertNotNull(savedCategory);
	Assertions.assertEquals(categoryToUpdate.getCode(), savedCategory.getCode());
	Assertions.assertEquals(categoryToUpdate.getDesignation(), savedCategory.getDesignation());
	Assertions.assertEquals(categoryToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());
	//assertNotNull(savedCategory.getId());
	}
	@Test
	public void shouldThrowInvalidEntityException(){
	CategoryDto expectedCat=CategoryDto.builder().build();
	
	InvalidEntityException expectedException=assertThrows(InvalidEntityException.class,()->catSer.save(expectedCat));
	assertEquals(ErrorCodes.CATEGORY_NOT_VALID,expectedException.getErrorCode());
	
	}
	@Test
	public void shouldThrowEntityNotFoundException(){

		EntityNotFoundException expectedException=assertThrows(EntityNotFoundException.class,()->catSer.findById(0));
	assertEquals(ErrorCodes.CATEGORY_NOT_FOUND,expectedException.getErrorCode());
	
	}
	@Test(expected = EntityNotFoundException.class)
	public void shouldThrowEntityNotFoundException2(){

		catSer.findById(0);
	
	}
}
