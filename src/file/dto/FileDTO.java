package file.dto;

public class FileDTO {

	String fileName;
	String fileRealName;
	
	public FileDTO(String fileName, String fileRealName) {
		this.fileName = fileName;
		this.fileRealName = fileRealName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	
	
}
