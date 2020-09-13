package img_comment;

public class ImgComment {

	private int num;
	private int img_num;
	private String writer;
	private String content;

	public ImgComment() {
	}

	public ImgComment(int num, int img_num, String writer, String content) {
		this.num = num;
		this.img_num = img_num;
		this.writer = writer;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getImg_num() {
		return img_num;
	}

	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ImgComment [num=" + num + ", img_num=" + img_num + ", writer=" + writer + ", content=" + content + "]";
	}

}
