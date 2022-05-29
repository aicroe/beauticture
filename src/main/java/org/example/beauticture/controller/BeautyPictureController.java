package org.example.beauticture.controller;

import org.example.beauticture.core.BeautyPicture;
import org.example.beauticture.core.ClassicBeautyPicture;
import org.example.beauticture.worker.AwtWorker;
import org.example.beauticture.worker.SolidBackgroundBrush;
import org.example.beauticture.worker.TextStroke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BeautyPictureController {

    @GetMapping(value = "beautify", produces = "image/png")
    public ResponseEntity<byte[]> buildBeautyPicture(@RequestParam("text") String text) {
        AwtWorker worker = new AwtWorker(500, 500);
        worker.addBrush(new SolidBackgroundBrush("#FF00FF", 500, 500));
        worker.addBrush(new TextStroke(text, "Monospaced", "#00FFFF", 50, 0));
        BeautyPicture bp = new ClassicBeautyPicture(worker);

        return ResponseEntity.ok().body(bp.build());
    }
}
