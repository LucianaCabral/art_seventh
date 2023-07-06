package com.lcabral.features.toprated.domain.usecase

import com.lcabral.features.toprated.domain.model.TopRated
import com.lcabral.features.toprated.domain.repository.TopRatedRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Test

internal class TopRatedUseCaseTest {
    private val topRatedRepository: TopRatedRepository = mockk(relaxed = true)
    private val subject = GetTopRatedUseCase(topRatedRepository)

    @Test
    fun `getTrendings Should return trendings movies`() {
        // Given
        val result: List<TopRated> = listOf(
            mockk(relaxed = true),
            mockk(relaxed = true),
            mockk(relaxed = true)
        )

        every { topRatedRepository.getTopRated() } returns flow { emit(result) }

        // When
        subject.invoke()

        // Then
        verify { topRatedRepository.getTopRated() }
    }

    @Test
    fun `getTrendings not  Should return trendings movies`() {
        // Given
        every { topRatedRepository.getTopRated() } returns flow { emit(emptyList()) }

        // When
        subject.invoke()

        // Then
        verify { topRatedRepository.getTopRated().wasNot(Called) }
    }
}