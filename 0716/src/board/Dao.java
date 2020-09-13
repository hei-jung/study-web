package board;

import java.util.ArrayList;

public interface Dao {

	void insert(Board b);

	Board selectById(int num);

	ArrayList<Board> selectByWriter(String writer);

	ArrayList<Board> selectByTitle(String title);

	ArrayList<Board> select();

	void update(Board b);

	void delete(int num);

}
