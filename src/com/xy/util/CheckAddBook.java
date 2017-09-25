package com.xy.util;

import java.awt.print.Book;

import com.xy.entity.Books;

public class CheckAddBook {
     public boolean checkAddBook(Books addbook )
     { 
    	 if(addbook.getBname().isEmpty()) return false;
    	 if(addbook.getBauthor().isEmpty()) return false;
    	 if(addbook.getBissue().isEmpty()) return false;
    	 if(addbook.getBnumber().isEmpty()) return false;
    	 if((addbook.getBprice()+"").isEmpty()) return false;
    	 if(addbook.getBisbn().isEmpty()) return false;
    	 if((addbook.getBstock()+"").isEmpty()) return false;
    	return true;
     }
}
