package com.lcabral.features.popular.domain.usecase

import com.lcabral.features.popular.domain.model.Popular
import com.lcabral.features.popular.domain.repository.PopularRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Test

internal class GetPopularUseCaseTest {
    private val popularRepository: PopularRepository = mockk(relaxed = true)
    private val subject = GetPopularUseCase(popularRepository)

    @Test
    fun `getTrendings Should return trendings movies`() {
        // Given
        val result: List<Popular> = listOf(
            mockk(relaxed = true),
            mockk(relaxed = true),
            mockk(relaxed = true)
        )

        every { popularRepository.getPopular() } returns flow { emit(result) }

        // When
        subject.invoke()

        // Then
        verify { popularRepository.getPopular() }
    }

    @Test
    fun `getTrendings not  Should return trendings movies`() {
        // Given
        every { popularRepository.getPopular() } returns flow { emit(emptyList()) }

        // When
        subject.invoke()

        // Then
        verify { popularRepository.getPopular().wasNot(Called) }
    }
}