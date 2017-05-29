package com.parker.pharlap.service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.parker.pharlap.domain.Race;
import com.parker.pharlap.domain.RaceDay;
import com.parker.pharlap.domain.Track;
import com.parker.pharlap.utils.DateUtils;

/**
 * Service for locating horse and race data.
 */
@Service
public class DataMiningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataMiningService.class);

    @Value("${url.form}")
    private String formUrl;

    @Value("${url.race.form}")
    private String raceFormUrl;

    @Value("${url.horse}")
    private String horseUrl;

    @Value("${url.race.result}")
    private String raceUrl;

    @Value("${url.jockey}")
    private String jockeyUrl;

    public List<RaceDay> getUpcomingRaceDays() {
        List<RaceDay> raceDays = new ArrayList<>();

        Document document = getDocument(formUrl);
        Element container = document.select("#formListContainer").first();

        for (Element dateElement : container.getElementsByClass("form_date_header")) {
            Date raceDate = parseDate(dateElement.text());
            RaceDay raceDay = new RaceDay(raceDate);

            Element meetingElement = dateElement.parent().nextElementSibling().child(0);
            while (meetingElement.attr("class").contains("form_meeting_info")) {
                String trackName = meetingElement.text().split(" - ")[0];

                Track track = Track.findByName(trackName.replaceAll(" ", "_").toUpperCase());
                if (track != null) {
                    raceDay.addTrack(track);
                }
                
                meetingElement = meetingElement.parent().nextElementSibling();
                if (meetingElement == null) {
                    break;
                }

                meetingElement = meetingElement.child(0);
            }

            if (!raceDay.getTracks().isEmpty()) {
                raceDays.add(raceDay);
                LOGGER.info(raceDay.getDate().toString());

                for (Track track : raceDay.getTracks().keySet()) {
                    LOGGER.info(track.name());
                }
                LOGGER.info("-----------------------------------------------------------------------------");
            }
        }

        // Populate track data
        for (RaceDay raceDay : raceDays) {
            int raceNo = 1;
            for (Track track : raceDay.getTracks().keySet())

                updateRaceForm(track, raceDay.getDate(), raceNo++);

        }

        return raceDays;
    }

    protected Date parseDate(String dateString) {
        try {
            return DateUtils.parseDate(dateString, "EEEEE - dd MMM yyyy");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRaceForm(Track track, Date date, int raceNo) {
        String dateString = DateUtils.format(date);
        String url = MessageFormat.format(raceFormUrl, track.getCode(), dateString, raceNo);
        Document document = getDocument(url);
        Element container = document.select("div#meetingContent").first();
        Element raceHeader = container.select("td > span.RaceNo").first();
        
        String raceText = raceHeader.parent().nextElementSibling().child(0).text();
        String[] parts = raceText.split(" ");
        int distance = Integer.valueOf(parts[parts.length - 1].replaceAll("m", ""));
        
        Race race = new Race();
        race.setDistance(distance);
        
        for (Element raceElement : container.select("table.HorseHeader")) {
        
        
            
        }
        
        LOGGER.info(getDocument(url).html());
    }

    public void getHorse(String name) {
        String url = MessageFormat.format(horseUrl, name);
        LOGGER.info(getDocument(url).html());
    }

    protected Document getDocument(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return Jsoup.parse(responseEntity.getBody());
    }

}
