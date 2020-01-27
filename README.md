# student-microservice-using-resttemplate

@GetMapping("/getStudentDetail/{studentId}")
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> getStudent(Exception ex,WebRequest request,@Valid @PathVariable Long studentId) {
    	String errorMessage = ex.getLocalizedMessage();
    	
    	if(errorMessage == null) {
    		errorMessage =ex.toString();
    	}
    	
    	StudentException studentException = new StudentException(new Date(),errorMessage);
    	studentService.getStudent(studentId);
    	System.err.println("service Id>>>>>"+studentId);
    	return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.OK);
    	
    }
