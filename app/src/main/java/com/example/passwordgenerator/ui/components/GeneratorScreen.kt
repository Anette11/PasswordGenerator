package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.passwordgenerator.Constants
import com.example.passwordgenerator.GeneratorViewModel
import com.example.passwordgenerator.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun GeneratorScreen(
    viewModel: GeneratorViewModel = viewModel()
) {
    val message = stringResource(id = R.string.copied)
    val clipboardManager = LocalClipboardManager.current
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var snackBarJob: Job? = null

    var password by remember { mutableStateOf("") }
    var lowerCase by remember { mutableStateOf(true) }
    var upperCase by remember { mutableStateOf(true) }
    var numbers by remember { mutableStateOf(true) }
    var symbols by remember { mutableStateOf(true) }
    var length by remember { mutableStateOf(Constants.defaultLength) }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(it) { snackBarData ->
                Snackbar(
                    backgroundColor = MaterialTheme.colors.primary,
                    snackbarData = snackBarData
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.top_app_bar_title))
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ResultField(
                password = password,
                onCopyClick = {
                    if (viewModel.checkIfCopyIsEnable(password)) {
                        clipboardManager.setText(AnnotatedString(password))
                        snackBarJob?.cancel()
                        snackBarJob = coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(message)
                        }
                    }
                },
                isEnable = viewModel.checkIfCopyIsEnable(password)
            )
            ButtonGenerate(
                isEnable = viewModel.checkIfGenerateIsEnable(
                    lowerCase = lowerCase,
                    upperCase = upperCase,
                    numbers = numbers,
                    symbols = symbols,
                    length = length
                ),
                onClick = {
                    password = viewModel.generate(
                        lowerCase = lowerCase,
                        upperCase = upperCase,
                        numbers = numbers,
                        symbols = symbols,
                        length = length
                    )
                }
            )
            ConditionSector(
                isSelected = lowerCase,
                text = stringResource(id = R.string.lower_case),
                onClick = { lowerCase = !lowerCase }
            )
            ConditionSector(
                isSelected = upperCase,
                text = stringResource(id = R.string.upper_case),
                onClick = { upperCase = !upperCase }
            )
            ConditionSector(
                isSelected = numbers,
                text = stringResource(id = R.string.numbers),
                onClick = { numbers = !numbers }
            )
            ConditionSector(
                isSelected = symbols,
                text = stringResource(id = R.string.symbols),
                onClick = { symbols = !symbols }
            )
            LengthSelector(
                length = length,
                onIncreaseClick = { if (length < Constants.maxLength) length++ },
                onDecreaseClick = { if (length > Constants.minLength) length-- },
                isIncreaseEnable = length < Constants.maxLength,
                isDecreaseEnable = length > Constants.minLength
            )
        }
    }
}