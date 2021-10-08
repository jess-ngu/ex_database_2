package ca.sheridancollege.nguye399.database;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.nguye399.drinks.*;

@Repository
public class DrinkRepository {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void addDrink() {
		String query = "INSERT INTO easy_drinks VALUES ('Jons drink', 'peach nectar', 3, 'orange juice', 5, 'serve over ice with straw')";
		jdbc.update(query, new HashMap());
	}

	public void addDrink(Drink drink) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_drinks VALUES (:name, :main, :a1, :sec, :a2, :dir)";
		parameters.addValue("name", drink.getName());
		parameters.addValue("main", drink.getMain());
		parameters.addValue("a1", drink.getAmount1());
		parameters.addValue("sec", drink.getSecond());
		parameters.addValue("a2", drink.getAmount2());
		parameters.addValue("dir", drink.getDirections());
		jdbc.update(query, parameters);
	}

	public ArrayList<Drink> getDrinks() {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM easy_drinks";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			Drink d = new Drink();
			d.setName((String) (row.get("drink_name")));
			d.setMain((String) (row.get("main")));
			d.setAmount1((Double) (row.get("amount1")));
			d.setSecond((String) (row.get("second")));
			d.setAmount2((Double) (row.get("amount2")));
			d.setDirections((String) (row.get("directions")));
			drinks.add(d);
		}
		return drinks;
	}

	public ArrayList<Drink> getDrinks2() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * From easy_drinks";
		ArrayList<Drink> drinks = (ArrayList<Drink>) jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Drink>(Drink.class));
		return drinks;
	}

}
