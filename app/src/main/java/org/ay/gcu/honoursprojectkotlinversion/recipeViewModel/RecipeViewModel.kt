package org.ay.gcu.honoursprojectkotlinversion.recipeViewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.ay.gcu.honoursprojectkotlinversion.recipeRepository.RecipeRepository
import javax.inject.Inject


@HiltViewModel
class RecipeViewModel @Inject constructor(
    recipeRepository: RecipeRepository
): ViewModel() {

    val readAll = recipeRepository.readAll
}