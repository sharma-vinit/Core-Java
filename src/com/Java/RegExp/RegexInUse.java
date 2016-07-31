/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vinit.sharma
 */
public class RegexInUse {
    
    private Pattern UsernamePattern, PasswordPattern, HexPattern, EmailPattern, ImagePattern;
    private Matcher matcher;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    /*  Username Regular Expression Pattern         ^[a-z0-9_-]{3,15}$
            ^                    # Start of the line
            [a-z0-9_-]           # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
            {3,15}               # Length at least 3 characters and maximum length of 15 
            $                    # End of the line
     */
    
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    /*  Password Regular Expression Pattern         ((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})
        (			#   Start of group
            (?=.*\d)		#   must contains one digit from 0-9
            (?=.*[a-z])		#   must contains one lowercase characters
            (?=.*[A-Z])		#   must contains one uppercase characters
            (?=.*[@#$%])	#   must contains one special symbols in the list "@#$%"
                .   		#   match anything with previous condition checking
            {6,20}              #   length at least 6 characters and maximum of 20	
        )			#   End of group
    */
    
    private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    /*  Hexadecimal Color Code Regular Expression Pattern   ^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$
        ^		 #  start of the line
        #		 #  must constains a "#" symbols
        (		 #  start of group #1
        [A-Fa-f0-9]{6}   #  any strings in the list, with length of 6
            |		 #    ..or
        [A-Fa-f0-9]{3}   #  any strings in the list, with length of 3
        )		 #  end of group #1 
        $		 #  end of the line
    */
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /*  Email Regular Expression Pattern    ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@ [A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$
        ^                           #   start of the line
            [_A-Za-z0-9-]+          #   must start with string in the bracket [ ], must contains one or more (+)
            (                       #   start of group #1
            \\.[_A-Za-z0-9-]+       #   follow by a dot "." and string in the bracket [ ], must contains one or more (+)
            )*                      #   end of group #1, this group is optional (*)
            @			    #   must contains a "@" symbol
            [A-Za-z0-9]+            #   follow by string in the bracket [ ], must contains one or more (+)
            (                       #	start of group #2 - first level TLD checking
            \\.[A-Za-z0-9]+         #	follow by a dot "." and string in the bracket [ ], must contains one or more (+)
            )*                      #	end of group #2, this group is optional (*)
            (                       #	start of group #3 - second level TLD checking
            \\.[A-Za-z]{2,}         #	follow by a dot "." and string in the bracket [ ], with minimum length of 2
            )                       #	end of group #3
        $                           #   end of the line
    */
    private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)";
    // Method to compile Patterns
    public void PatternCompile(){
        UsernamePattern = Pattern.compile(USERNAME_PATTERN);
        PasswordPattern = Pattern.compile(PASSWORD_PATTERN);
        HexPattern = Pattern.compile(HEX_PATTERN);
        EmailPattern = Pattern.compile(EMAIL_PATTERN);
        ImagePattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)");
    }
 
      /**********************************************************
       * Validate username with regular expression
       * @param username username for validation
       * @return true valid username, false invalid username
      */
        public boolean validateUserName(final String username){
            PatternCompile();
            matcher = UsernamePattern.matcher(username);
            return matcher.matches();
        }
    
        /**********************************************************
         * Validate password with regular expression
         * @param password password for validation
         * @return true valid password, false invalid password
        */
        public boolean validatePassword(final String password){
          PatternCompile();
          matcher = PasswordPattern.matcher(password);
          return matcher.matches();
        }
      
      /**********************************************************
       * Validate hex with regular expression
       * @param hex hex for validation
       * @return true valid hex, false invalid hex
       */
        public boolean validateHexColor(final String hex){
           PatternCompile();
           matcher = HexPattern.matcher(hex);
           return matcher.matches();
       }
       
        /**********************************************************
	 * Validate email with regular expression
	 * @param email email for validation
	 * @return true valid email, false invalid email
	 */
	 public boolean validateEmail(final String email){
             PatternCompile();
             matcher = EmailPattern.matcher(email);
             return matcher.matches();
         }
        
        /**
	   * Validate image with regular expression
	   * @param image image for validation
	   * @return true valid image, false invalid image
	   */
	   public boolean validateImageExtension(final String image){
		  System.out.println("Inside validation of image...." + image);
		  
		  try{
			  matcher = ImagePattern.matcher(image);
/*
 * Pic name:android.jpg
 * Inside validation of image....android.jpg
 * null
 * java.lang.NullPointerException
 */

          }catch(Exception e){
         	 System.out.println(e.getMessage());
         	System.out.println(e);
          }
		  System.out.println("Matching complete .........	" + matcher.matches());
		  return matcher.matches();
	 
	   }

}
