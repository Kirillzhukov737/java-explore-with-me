package ru.yandex.practicum.hit;

import ru.yandex.practicum.HitDto;

import java.util.ArrayList;
import java.util.List;

public class HitMapper {
    /**
     * Преобразует объект `Hit` в объект `HitDto`.
     *
     * @param hit объект `Hit`
     * @return объект `HitDto`
     */
    public static HitDto returnHitDto(Hit hit) {
        HitDto hitDto = HitDto.builder()
                .id(hit.getId())
                .app(hit.getApp())
                .uri(hit.getUri())
                .ip(hit.getIp())
                .timestamp(hit.getTimestamp())
                .build();
        return hitDto;
    }

    /**
     * Преобразует объект `HitDto` в объект `Hit`.
     *
     * @param hitDto объект `HitDto`
     * @return объект `Hit`
     */
    public static Hit returnHit(HitDto hitDto) {
        Hit hit = Hit.builder()
                .id(hitDto.getId())
                .app(hitDto.getApp())
                .uri(hitDto.getUri())
                .ip(hitDto.getIp())
                .timestamp(hitDto.getTimestamp())
                .build();
        return hit;
    }

    /**
     * Преобразует список объектов `Hit` в список объектов `HitDto`.
     *
     * @param hits список объектов `Hit`
     * @return список объектов `HitDto`
     */
    public static List<HitDto> returnHitDtoList(Iterable<Hit> hits) {
        List<HitDto> result = new ArrayList<>();
        for (Hit hit : hits) {
            result.add(returnHitDto(hit));
        }
        return result;
    }
}