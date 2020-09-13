package board;

import java.util.ArrayList;

public interface Service {

	void addBoard(Board b);

	Board getById(int num);

	ArrayList<Board> getByWriter(String writer);

	ArrayList<Board> getByTitle(String title);

	ArrayList<Board> getAll();

	void editBoard(Board b);

	void delBoard(int num);

}
