package lookids.mono.followblock.follow.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lookids.mono.followblock.follow.domain.FollowInfo;

public interface FollowInfoRepository extends JpaRepository<FollowInfo, Long>, FollowInfoRepositoryCustom {
	void deleteBySenderUuidAndReceiverUuid(String senderUuid, String receiverUuid);

	List<FollowInfo> findBySenderUuid(String senderUuid);

	List<FollowInfo> findByReceiverUuid(String receiverUuid);
}
