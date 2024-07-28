package com.example.lab5example2.Controller;

import com.example.lab5example2.API.APIController;
import com.example.lab5example2.Model.Tracker;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Data
@RestController
@RequestMapping("/api/v1/tracker")
public class trackerController {
    ArrayList<Tracker> trackers = new ArrayList<Tracker>();
    @GetMapping("/get")
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }
    @PostMapping("/add")
    public APIController addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new APIController("Successfully added tracker");
    }
    @PutMapping("/update/{index}")
    public APIController updateTracker(@PathVariable int index,@RequestBody Tracker tracker) {
        trackers.add(index, tracker);
        return new APIController("Successfully updated tracker");
    }
    @DeleteMapping("/delete/{index}")
    public APIController deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return new APIController("Successfully deleted tracker");
    }
    @PutMapping("/set/{index}")
    public APIController setTracker(@PathVariable int index) {
        if (trackers.get(index).getStatus().equalsIgnoreCase(" not done")) {
            trackers.get(index).setStatus("done");
            return new APIController("Successfully change status to  done");
        }
        return new APIController("It's already done");
    }
    @GetMapping("/search/{str}")
    public Tracker searchTracker(@PathVariable String str) {
        for (Tracker tracker : trackers) {
            if (tracker.getTitle().equalsIgnoreCase(str)) {
                return tracker;
            }

        }  return null;}

    @GetMapping("/display/{company}")
    public ArrayList<Tracker> displayTracker(@PathVariable String company) {
        ArrayList<Tracker> trackerrs = new ArrayList<>();
        for (Tracker tracker : trackers) {
            if (tracker.getCompanyName().equalsIgnoreCase(company)) {
                trackerrs.add(tracker);
            }
        }
        return trackerrs;


    }




}





