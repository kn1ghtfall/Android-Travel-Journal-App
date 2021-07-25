package ro.scoalainformala.traveljournal.trip;

import java.util.ArrayList;
import java.util.List;

import ro.scoalainformala.traveljournal.R;

public class TripsDataSource {

    private final ArrayList<Trip> trips = new ArrayList<>();


    public TripsDataSource() {
        trips.add(new Trip(R.drawable.cyclades_islands_greece, "Best of Greece"
                , 3.4F, "Athens", "Greece", "5 to 99", "10 days", "1143", true));
        trips.add(new Trip(R.drawable.italy_trip_1, "Private Sicily Food & Wine Lovers Tour"
                , 5F, "Catania, Taormina, Mount Etna, Noto, Marzamemi, Syracuse, Palermo", "South Italy, Sicily", "3 to 99", "8 days", "1995", true));
        trips.add(new Trip(R.drawable.italy_trip_2_rome_venice, "Rome to Venice Adventure Tour"
                , 4.3F, "Rome, Florence, Cinque Terre, Venice", "Italy", "18 to 99", "10 days", "1519", false));
        trips.add(new Trip(R.drawable.turkey_trip_1_absolute_trukey, "Absolute Turkey"
                , 3.9F, "Istanbul, Ankara, Cappadocia, Konya, Antalya, Kas, Pamukkale, Selcuk, Ayvalik, Troy, Gallipoli", "Turkey", "12 to 99", "15 days", "1119", false));
        trips.add(new Trip(R.drawable.turkey_trip_2_treasures_of_turkey, "Treasures of Turkey"
                , 4.5F, "Istanbul, Gallipoli, Izmir, Kusadasi, Pamukkale, Antalya, Konya, Cappadocia", "Turkey", "12 to 99", "15 days", "4864", false));
        trips.add(new Trip(R.drawable.india_trip_1_golden_triangle, "Golden Triangle"
                , 4.5F, "New Delhi, Agra, Bharatpur, Jaipur", "India", "12 to 99", "8 days", "699", false));
        trips.add(new Trip(R.drawable.india_trip_2_taj_mahal_wildlife, "Taj Mahal and Wildlife with Royal Stay at Castles"
                , 4.8F, "New Delhi, Jodhpur, Luni, Sardargarh, Udaipur, Pushkar, Ranthambore National Park, Agra, Taj Mahal, Agra", "India", "18 to 99", "11 days", "1138", false));
        trips.add(new Trip(R.drawable.sri_lanka_trip_1_sri_lanka_experience, "Sri Lanka Experience"
                , 4.9F, "Colombo, Negombo, Dambulla, Sigiriya", "Sri Lanka", "18 to 55", "12 days", "1280", false));
        trips.add(new Trip(R.drawable.japan_trip_1_essential_japan, "Essential Japan"
                , 4.5F, "Tokyo, Kanazawa, Kyoto, Hiroshima, Osaka", "Japan", "18 to 29", "10 days", "2100", true));
        trips.add(new Trip(R.drawable.vietnam_trip_1_vietnam_experience, "Vietnam Experience"
                , 4.8F, "Ho Chi Minh City, Hoi An, Hue, Hanoi, Halong Bay", "Vietnam", "18 to 35", "12 days", "1110", true));
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
