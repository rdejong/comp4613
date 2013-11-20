package comp4613.data;

import java.util.*;

public class DisplayTable {

	public static String showHeaders(Collection<String> columnNames) {

		StringBuilder output = new StringBuilder();

		output.append("<TABLE class = \"alternateColour \" font color= \"black\">");

		output.append("<TR>");

		Iterator<String> i = columnNames.iterator();

		while (i.hasNext()) {

			output.append("<TH font color= \"black\">");

			output.append((String) i.next());

			output.append("</TH>");
		}
		output.append("</TR>");
		// output.append("</TABLE>");

		return output.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String showRows(Collection<Collection> rowData) {

		int rowIndex = 1;
		StringBuilder output = new StringBuilder();
		Iterator<Collection> i = rowData.iterator();

		// output.append("<TABLE>");
		while (i.hasNext()) {

			if (rowIndex % 2 == 0)// don't use this logic - use css instead

				output.append("<TR>");

			else

				output.append("<TR>");

			@SuppressWarnings("unchecked")
			ArrayList<String> aRow = (ArrayList<String>) i.next();
			Iterator<String> aRowI = aRow.iterator();

			while (aRowI.hasNext()) {

				output.append("<TD>");

				output.append((String) aRowI.next());

				output.append("</TD>");
			}

			output.append("</TR>");

			rowIndex++;

		}

		output.append("</TABLE>");

		return output.toString();

	}
}
