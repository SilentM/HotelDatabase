package ca.ubc.cs304.model;

import ca.ubc.cs304.modelInterface.Entity;
import ca.ubc.cs304.modelInterface.TableHelper;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomHelper extends TableHelper {

	@Override
	public String getTableName() {
		return "room";
	}

	@Override
	public String[] getPrimaryAttributes() {
		return new String[] {"room_number", "room_floor"};
	}

	public void printTupleInfo(Entity tuple) {
		Room roomTuple = (Room) tuple;
		// simplified output formatting; truncation may occur
		System.out.printf("%-10.10s", roomTuple.getNumber());
		System.out.printf("%-20.20s", roomTuple.getFloor());
		if (roomTuple.getType() == null) {
			System.out.printf("%-20.20s", " ");
		} else {
			System.out.printf("%-20.20s", roomTuple.getType());
		}
		System.out.printf("%-15.15s", roomTuple.getNumberOfBeds());
		System.out.printf("%-20.20s", roomTuple.getHotelAddress());
		System.out.println();
	}

	@Override
	public void setStatementParameter(PreparedStatement ps, int index, String key, JSONObject keyValuePairs) throws SQLException {
		try {
			switch (key) {
				case "room_number":
					ps.setInt(index, keyValuePairs.getInt("room_number"));
					break;
				case "room_floor":
					ps.setInt(index, keyValuePairs.getInt("room_floor"));
					break;
				case "room_type":
					ps.setString(index, keyValuePairs.getString("room_type"));
					break;
				case "room_numberOfBeds":
					ps.setInt(index, keyValuePairs.getInt("room_numberOfBeds"));
					break;
				case "room_hotelAddress":
					ps.setString(index, keyValuePairs.getString("room_hotelAddress"));
					break;
				default:
					throw new Error("Invalid Key!");
			}
		} catch (JSONException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
