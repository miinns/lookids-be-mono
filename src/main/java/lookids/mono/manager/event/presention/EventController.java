package lookids.mono.manager.event.presention;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lookids.mono.common.entity.BaseResponse;
import lookids.mono.common.entity.BaseResponseStatus;
import lookids.mono.manager.event.application.EventManagerService;
import lookids.mono.manager.event.dto.in.EventRequestDto;
import lookids.mono.manager.event.dto.in.EventUpdateRequestDto;
import lookids.mono.manager.event.dto.out.EventResponseDto;
import lookids.mono.manager.event.vo.in.EventRequestVo;
import lookids.mono.manager.event.vo.in.EventUpdateRequestVo;
import lookids.mono.manager.event.vo.out.EventResponseVo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/manager-service/event")
public class EventController {

	private final EventManagerService eventManagerService;

	@Operation(summary = "event 등록 API", description = "event 등록 API 입니다.", tags = {"Event"})
	@PostMapping
	public BaseResponse<Void> createEvent(@RequestBody EventRequestVo eventRequestVo) {
		eventManagerService.createEvent(EventRequestDto.toDto(eventRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "진행 중인 event 리스트 조회 API", description = "진행 중인 event 리스트 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/going")
	public BaseResponse<List<EventResponseVo>> readGoingEventList() {
		List<EventResponseDto> readGoingEventList = eventManagerService.readGoingEventList();
		return new BaseResponse<>(readGoingEventList.stream().map(EventResponseDto::toVo).toList());
	}

	@Operation(summary = "마감된 event 리스트 조회 API", description = "마감된 event 리스트 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/expired")
	public BaseResponse<List<EventResponseVo>> readExpiredEventList() {
		List<EventResponseDto> readExpiredEventList = eventManagerService.readExpiredEventList();
		return new BaseResponse<>(readExpiredEventList.stream().map(EventResponseDto::toVo).toList());
	}

	@Operation(summary = "event detail 조회 API", description = "event detail 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/detail")
	public BaseResponse<EventResponseVo> readEvent(@RequestParam String eventCode) {
		return new BaseResponse<>(eventManagerService.readEvent(eventCode).toVo());
	}

	@Operation(summary = "event 수정 API", description = "event 수정 API 입니다.", tags = {"Event"})
	@PutMapping()
	public BaseResponse<Void> updateEvent(@RequestParam String eventCode,
		@RequestBody EventUpdateRequestVo eventUpdateRequestVo) {
		eventManagerService.updateEvent(eventCode, EventUpdateRequestDto.toDto(eventCode, eventUpdateRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "event 삭제 API", description = "event 삭제 API 입니다.", tags = {"Event"})
	@DeleteMapping
	public BaseResponse<Void> deleteEvent(@RequestParam String eventCode) {
		eventManagerService.deleteEvent(eventCode);
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}
}
